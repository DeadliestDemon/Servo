package com.example.servo;

public class newComplaint {

    private long time;
    private long date;
    private String type;
    private String uid;
    private String studentID;
    private String workerID;
    private long roomno;
    private long rollno;
    private String Description;
    private long phoneStudent;
    private long phoneWorker;
    private long completedTime;
    private long completedDate;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public long getRoomno() {
        return roomno;
    }

    public void setRoomno(long roomno) {
        this.roomno = roomno;
    }

    public long getRollno() {
        return rollno;
    }

    public void setRollno(long rollno) {
        this.rollno = rollno;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(long phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public long getPhoneWorker() {
        return phoneWorker;
    }

    public long getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(long completedTime) {
        this.completedTime = completedTime;
    }

    public long getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(long completedDate) {
        this.completedDate = completedDate;
    }

    public void setPhoneWorker(long phoneWorker) {
        this.phoneWorker = phoneWorker;
    }

//    public newComplaint(long time, long date, String type, String uid, String studentID, String workerID, long roomno, long rollno, String description, long phoneStudent, long phoneWorker) {
//        this.time = time;
//        this.date = date;
//        this.type = type;
//        this.uid = uid;
//        this.studentID = studentID;
//        this.workerID = workerID;
//        this.roomno = roomno;
//        this.rollno = rollno;
//        Description = description;
//        this.phoneStudent = phoneStudent;
//        this.phoneWorker = phoneWorker;
//    }

    public newComplaint(long time, long date, String type, String uid, String studentID, String workerID, long roomno, long rollno, String description, long phoneStudent, long phoneWorker, long completedTime, long completedDate) {
        this.time = time;
        this.date = date;
        this.type = type;
        this.uid = uid;
        this.studentID = studentID;
        this.workerID = workerID;
        this.roomno = roomno;
        this.rollno = rollno;
        Description = description;
        this.phoneStudent = phoneStudent;
        this.phoneWorker = phoneWorker;
        this.completedTime = completedTime;
        this.completedDate = completedDate;
    }
}
