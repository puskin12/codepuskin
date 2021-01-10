# -*- coding: utf-8 -*-
"""
Created on Thu May  2 15:19:21 2019

@author: puskin
"""
import cv2
import numpy as np
import time
import vehicles

cap=cv2.VideoCapture('video1.mp4')
fgbg=cv2.createBackgroundSubtractorMOG2(detectShadows=False,history=200,varThreshold = 90)
kernalOp = np.ones((3,3),np.uint8)
kernalOp2 = np.ones((5,5),np.uint8)
kernalCl = np.ones((11,11),np.uint8)
font = cv2.FONT_HERSHEY_SIMPLEX
cars = []
max_p_age = 5
pid = 1
cnt_up=0
cnt_down=0

# count the number of frames: Duration
duration= cap.get(cv2.CAP_PROP_FRAME_COUNT) 
 
line_up=400
line_down=250

up_limit=230
down_limit=int(4.5*(500/5))

while(cap.isOpened()):
    if cap.get(cv2.CAP_PROP_POS_FRAMES) + 1 == cap.get(cv2.CAP_PROP_FRAME_COUNT):
        break
    ret,frame=cap.read()
    frame=cv2.resize(frame,(900,500))
    for i in cars:
        i.age_one()
    fgmask=fgbg.apply(frame)

    if ret==True:
        ret,imBin=cv2.threshold(fgmask,200,255,cv2.THRESH_BINARY)
        mask = cv2.morphologyEx(imBin, cv2.MORPH_OPEN, kernalOp)
        mask = cv2.morphologyEx(mask, cv2.MORPH_CLOSE, kernalCl)

        
        countours0=cv2.findContours(mask,cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_NONE)
        #(im,countours0,hierarchy)=cv2.findContours(mask,cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_NONE)
        for cnt in countours0[1]:
            area=cv2.contourArea(cnt)
            #print(area)
            if area>300:

                m=cv2.moments(cnt)
                cx=int(m['m10']/m['m00'])
                cy=int(m['m01']/m['m00'])
                x,y,w,h=cv2.boundingRect(cnt)

                new=True
                if cy in range(up_limit,down_limit):
                    for i in cars:
                        if abs(x - i.getX()) <= w and abs(y - i.getY()) <= h:
                            new = False
                            i.updateCoords(cx, cy)

                            if i.going_UP(line_down,line_up)==True:
                                cnt_up+=1

                            elif i.going_DOWN(line_down,line_up)==True:
                                cnt_down+=1

                            break
                        if i.getState()=='1':
                            if i.getDir()=='down'and i.getY()>down_limit:
                                i.setDone()
                            elif i.getDir()=='up'and i.getY()<up_limit:
                                i.setDone()
                        if i.timedOut():
                            index=cars.index(i)
                            cars.pop(index)
                            del i

                    if new==True:
                        p=vehicles.Car(pid,cx,cy,max_p_age)
                        cars.append(p)
                        pid+1
                cv2.circle(frame, (cx, cy), 2, (0, 0, 255), -1)

                img=cv2.rectangle(frame,(x,y),(x+w,y+h),(0,255,0),2)


        for i in cars:
            cv2.putText(frame, str(i.getId()), (i.getX(), i.getY()), font, 0.3, (255,255,0), 1, cv2.LINE_AA)
            if line_down+20 <= i.getY() <= line_up-20:
               a = (h + (.74*w)- 100)

               if a >= 0:
                     cv2.putText(frame, "Truck", (i.getX(), i.getY()), font, 1, (0,0,255), 2, cv2.LINE_AA)
               else:
                     cv2.putText(frame, "car", (i.getX(), i.getY()), font, 1, (0,0,255), 2, cv2.LINE_AA)


        str_up='UP: '+str(cnt_up)
        str_down='DOWN: '+str(cnt_down)
        #frame=cv2.line(frame,(0,line_up),(900,line_up),(0,0,255),3,8)
        #frame=cv2.line(frame,(0,up_limit),(900,up_limit),(0,0,0),1,8)

        #frame=cv2.line(frame,(0,down_limit),(900,down_limit),(255,255,0),1,8)
        #frame = cv2.line(frame, (0, line_down), (900, line_down), (255, 0,0), 3, 8)

        cv2.putText(frame, str_up, (10, 40), font, 1, (0, 0, 255), 2, cv2.LINE_AA)
        cv2.putText(frame, str_down, (10, 90), font, 1, (255, 0, 0), 2, cv2.LINE_AA)
        cv2.imshow('Frame',frame)

        if cv2.waitKey(1)&0xff==ord('q'):
            break
    else:
        break


#calculate density
traffic_density=cnt_down/duration;
print('Traffic density is',traffic_density)

#define three levels of density
low_traffic=0.012
medium_traffic=0.024

#after the video ends, 
#  DEFINE TWO IMAGE WINDOWS:
 # FIRST WINDOW (1st red light) 
#low density: 5 second green, 5 second red
#medium density: 10 second green,5 second red
#high density: 15 second green,5 second red

# second window (2nd red light)
 # the functioning will be complementary
light_size=350
light1 = np.zeros((light_size, light_size, 3), np.uint8)
light2 = np.zeros((light_size, light_size, 3), np.uint8)
#green=(0,255,0)
#red=(0,0,255)
green=cv2.imread('go.jpg')
green=cv2.resize(green,(light_size,light_size))
red=cv2.imread('stop.jpg')
red=cv2.resize(red,(light_size,light_size))

while(1):
    if traffic_density < low_traffic:
        print('Traffic Density is LOW (Green time= 5s)')
        light1[:,:]=green
        light2[:,:]=red
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(5000)
        
        light1[:,:]=red
        light2[:,:]=green
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(5000)
        
    elif traffic_density >= low_traffic and traffic_density <=medium_traffic:
        print('Traffic Density is MEDIUM (Green time= 10s)')
        light1[:,:]=green
        light2[:,:]=red
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(10000)
        
        light1[:,:]=red
        light2[:,:]=green
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(5000)
    else:
        print('CONGESTION EXISTS !!!')
        print('Traffic Density is HIGH (Green time= 15s)')
        light1[:,:]=green
        light2[:,:]=red
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(15000)
        
        light1[:,:]=red
        light2[:,:]=green
        cv2.imshow('SIGNAL 1st',light1)
        cv2.imshow('SIGNAL 2nd',light2)
        k=cv2.waitKey(5000)
    
    if k&0xff==ord('q'):
            break

cap.release()
cv2.destroyAllWindows()
