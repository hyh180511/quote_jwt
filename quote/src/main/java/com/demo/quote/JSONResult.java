package com.demo.quote;

/**
 * Created by hyh on 18/4/17.
 */
public class JSONResult {
    public JSONResult(){}
    public JSONResult(String errorcode) {
        this.errorcode = errorcode;
    }

    public JSONResult(Object data){
        this.data = data;
    }

    public JSONResult(String errorcode, String errormsg) {
        this.errorcode = errorcode;
        this.errormsg = errormsg;
    }

    public JSONResult(String errorcode, Object data){
        this.errorcode = errorcode;
        this.data = data;
    }

    public JSONResult(String errorcode, String errormsg, Object data){
        this.errorcode = errorcode;
        this.errormsg = errormsg;
        this.data = data;
    }

    private String errorcode = "0";
    private String errormsg = "";
    private Object data = "";

    public String getErrorcode(){
        return errorcode;
    }

    public void setErrorcode(String errorcode){
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
