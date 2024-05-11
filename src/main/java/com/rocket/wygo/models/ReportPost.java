package com.rocket.wygo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "report_post")
public class ReportPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "report_object", nullable = false)
    private Post reportObject;

    @Column(name = "report_type", nullable = false)
    private String reportType;
    public ReportPost() {
    }

    public ReportPost(User author, Post reportObject, String reportType) {
        this.author = author;
        this.reportObject = reportObject;
        this.reportType = reportType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getReportObject() {
        return reportObject;
    }

    public void setReportObject(Post reportObject) {
        this.reportObject = reportObject;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
