package com.huobi.demo.socketio.main;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huobi.demo.socketio.core.IOAcknowledge;
import com.huobi.demo.socketio.core.IOCallback;
import com.huobi.demo.socketio.core.SocketIO;
import com.huobi.demo.socketio.core.SocketIOException;


public class DataReciever {

    private String url = "http://hq.huobi.com:80/";// hqUrl

    private static volatile SocketIO socket;

    private static Logger logger = LoggerFactory.getLogger(DataReciever.class);

    public DataReciever() 
    {
    }

    public DataReciever connectToSocketIO() 
    {
        try {
            socket = new SocketIO(url,new IOCallback() {
                    @Override
                    public void onMessage(JSONObject json, IOAcknowledge ack) {

                    }

                    @Override
                    public void onMessage(String data, IOAcknowledge ack) 
                    {
                    }

                    @Override
                    public void onError(SocketIOException socketIOException) 
                    {                        
                        logger.warn("",socketIOException);
                        socket.disconnect();
                    }

                    @Override
                    public void onDisconnect() 
                    {
                        logger.warn("socket.io disconnect");
                    }

                    @Override
                    public void onConnect() {
                        logger.info("socket.io connected-------------");
                        
                    }

                    @Override
                    public void on(final String event, IOAcknowledge ack, final Object... args) 
                    {                        
                        try 
                        {
                            DataReciever.dispatcher((JSONObject)args[0]);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                });
            register();
        } catch (Exception e) {
            logger.error("",e);
        }
        return this;
    }


    public static void dispatcher(JSONObject recieveJO) throws Exception {
        String msgType = recieveJO.getString("msgType");
        logger.debug(msgType);
        switch (msgType) 
        {
        case "reqTimeLine":
            break;
        case "reqKLine":
            break;
        case "reqMarketDepthTop":            
            break;
        case "marketDepthTopDiff":            
            break;
        case "reqTradeDetailTop":           
            break;
        case "reqMarketDetail":            
            break;
        case "reqMarketDepth":
            break;
        case "marketDetail":
            break;
        case "tradeDetail":
            break;
        case "marketDepthDiff":
            break;
        case "lastKLine":
            break;
        case "lastTimeLine":
            break;
        case "marketOverview":
            break;
        default:
            break;
        // case "reqMsgSubscribe":
        // break;
        // case "marketDepthTop":
        // break;
        // case "marketDepthTopShort":
        // break;
        // case "marketDepth":
        // break;
        // default:
        // break;
        }
    }
    public void register()
    {

        // 需要什么数据就可以注册对应的消息。
        // 比特币
        // 请求top市场深度
//        var strMsg = '{"symbolId":"btccny","version":1,"msgType":"reqMarketDepthTop","requestIndex":1405131204513}';

        // 实时数据推送
        String strMsg = "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
                +                   "\"lastKLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"1min\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"5min\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"15min\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"30min\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"60min\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"1day\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"1week\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"1mon\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"period\":\"1year\"}"
                +                                  "],"
                +                   "\"marketDepthDiff\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"percent\":\"10\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"percent\":\"20\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"percent\":\"50\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"percent\":\"80\"},"
                +                                  "{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\",\"percent\":\"100\"}"
                +                                  "],"
                +                   "\"marketDepthTopDiff\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
                +                   "\"marketDetail\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
                +                   "\"tradeDetail\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
                +                   "\"marketOverview\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}]"
                +                  "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";

        
//        // 莱特币
//      var strMsg = '{"symbolList":{"lastTimeLine":[{"symbolId":"ltccny","pushType":"pushLong"}],'
//              +                   '"lastKLine":[{"symbolId":"ltccny","pushType":"pushLong","period":"1min"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"5min"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"15min"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"30min"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"60min"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"1day"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"1week"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"1mon"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","period":"1year"}'
//              +                                  '],'
//              +                   '"marketDepthDiff":[{"symbolId":"ltccny","pushType":"pushLong","percent":"10"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","percent":"20"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","percent":"50"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","percent":"80"},'
//              +                                  '{"symbolId":"ltccny","pushType":"pushLong","percent":"100"}'
//              +                                  '],'
//              +                   '"marketDepthTopDiff":[{"symbolId":"ltccny","pushType":"pushLong"}],'
//              +                   '"marketDetail":[{"symbolId":"ltccny","pushType":"pushLong"}],'
//              +                   '"tradeDetail":[{"symbolId":"ltccny","pushType":"pushLong"}],'
//              +                   '"marketOverview":[{"symbolId":"ltccny","pushType":"pushLong"}]'
//              +                  '},"version":1,"msgType":"reqMsgSubscribe","requestIndex":1404103038520}';
        JSONObject sendJO = new JSONObject(new JSONTokener(strMsg));
        socket.emit("request", sendJO);
    }

    public boolean isConnected()
    {
        return socket!=null&&socket.isConnected();
    }
    public long getLastTimeReceivedMessage()
    {
        return socket==null?-1:socket.getLastTimeReceivedMessage();
    }
    public void disconnect()
    {
        if(socket == null)
        {
            return;
        }
        socket.disconnect();
        socket = null;
    }
}
