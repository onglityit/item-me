package com.darren.mongorest.model.response;

public abstract class PagedResponse {
    protected int totalPages;
    protected int currentPageNum;
    protected int pageSize;
}
