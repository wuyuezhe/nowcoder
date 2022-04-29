package com.nowcoder.community.pojo;

public class Page {
    public int currentPage = 1;
    public int limit = 10;
    public int totalCount;
    public String url;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage > 0) {
            this.currentPage = currentPage;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (1 <= limit && limit <= 100) {

            this.limit = limit;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount >= 0) {
            this.totalCount = totalCount;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return (currentPage - 1) * limit;
    }

    public int getPageCount() {
        return totalCount % limit == 0 ? totalCount / limit : totalCount / limit + 1;
    }

    public int getFrom() {
        if (currentPage <= 3) {
            return 1;
        }
        return currentPage-2;
    }

    public int getTo(){
        if ((this.getPageCount()-currentPage)<=2){
            return this.getPageCount();
        }
        return currentPage+2;
    }
}
