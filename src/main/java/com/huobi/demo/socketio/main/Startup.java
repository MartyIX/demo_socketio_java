package com.huobi.demo.socketio.main;

public class Startup 
{
    public static void main(String[] adsfa)
    {
        DataReciever dataReciever = new DataReciever().connectToSocketIO();
        new CheckConnection(dataReciever).check();
    }
}
