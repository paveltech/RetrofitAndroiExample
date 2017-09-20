package com.example.android.retrofitandroiexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by android on 9/21/2017.
 */

public class ActorResponce {

    @SerializedName("total")
    @Expose
    public int total;
    @SerializedName("per_page")
    @Expose
    public int perPage;
    @SerializedName("current_page")
    @Expose
    public int currentPage;
    @SerializedName("last_page")
    @Expose
    public int lastPage;
    @SerializedName("next_page_url")
    @Expose
    public String nextPageUrl;
    @SerializedName("prev_page_url")
    @Expose
    public Object prevPageUrl;
    @SerializedName("from")
    @Expose
    public int from;
    @SerializedName("to")
    @Expose
    public int to;
    @SerializedName("data")
    public ArrayList<Actorlist> actorlistArrayList;

    public ArrayList<Actorlist> getActorlistArrayList() {
        return actorlistArrayList;
    }

    public void setActorlistArrayList(ArrayList<Actorlist> actorlistArrayList) {
        this.actorlistArrayList = actorlistArrayList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
