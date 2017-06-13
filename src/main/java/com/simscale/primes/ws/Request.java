package com.simscale.primes.ws;


public class Request {

    private long id;
    private long timestamp;
    private int start;
    private int end;
    private long timeElapsed;
    private String algorithmType;
    private int numOfPrimes;

    public Request() {
    }

    public Request(long id, long timestamp, int start, int end, long timeElapsed, String algorithmType, int numOfPrimes) {
        this.id = id;
        this.timestamp = timestamp;
        this.start = start;
        this.end = end;
        this.timeElapsed = timeElapsed;
        this.algorithmType = algorithmType;
        this.numOfPrimes = numOfPrimes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public int getNumOfPrimes() {
        return numOfPrimes;
    }

    public void setNumOfPrimes(int numOfPrimes) {
        this.numOfPrimes = numOfPrimes;
    }
}