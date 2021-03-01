package com.theekshana.codefestexam.Model;

public class Tickect {

    String NAme;
    String Body;
    String complain;
    String DocID;

    public Tickect() {
    }

    public Tickect(String NAme, String body, String complain, String docID) {
        this.NAme = NAme;
        Body = body;
        this.complain = complain;
        DocID = docID;
    }

    public String getNAme() {
        return NAme;
    }

    public void setNAme(String NAme) {
        this.NAme = NAme;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public String getDocID() {
        return DocID;
    }

    public void setDocID(String docID) {
        DocID = docID;
    }
}
