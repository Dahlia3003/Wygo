package com.rocket.wygo.response;

public class ReportPostResponse {
    private Long id;
    private UserResponse author;
    private PostResponse reportObject;
    private String reportType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportPostResponse(Long id, UserResponse author, PostResponse reportObject, String reportType) {
        this.id = id;
        this.author = author;
        this.reportObject = reportObject;
        this.reportType = reportType;
    }

    public ReportPostResponse() {
    }

    public UserResponse getAuthor() {
        return author;
    }

    public void setAuthor(UserResponse author) {
        this.author = author;
    }

    public PostResponse getReportObject() {
        return reportObject;
    }

    public void setReportObject(PostResponse reportObject) {
        this.reportObject = reportObject;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
