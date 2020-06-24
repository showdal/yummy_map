package com.yummymap.mmy.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class TxtVO {
	private int rno, mno, txtno, count, rnum, catno, upno, step, reno;
	private String title, mid, mname, mtxt, cdate, category, isrec, edit, editdate;
	private Date jDate;
	private Time jTime;

	public int getRno() {
		return this.rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getMno() {
		return this.mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getTxtno() {
		return this.txtno;
	}

	public void setTxtno(int txtno) {
		this.txtno = txtno;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRnum() {
		return this.rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getCatno() {
		return this.catno;
	}

	public void setCatno(int catno) {
		this.catno = catno;
	}

	public int getUpno() {
		return this.upno;
	}

	public void setUpno(int upno) {
		this.upno = upno;
	}

	public int getStep() {
		return this.step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtxt() {
		return this.mtxt;
	}

	public void setMtxt(String mtxt) {
		this.mtxt = mtxt;
		this.mtxt = mtxt.replaceAll("\r\n", "<br>");
	}

	public void setMtxt() {
		this.mtxt = this.mtxt.replaceAll("<br>", "\r\n");
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat form2 = new SimpleDateFormat("hh24:mi:ss");
		this.cdate = form1.format(this.jDate) + " " + form2.format(this.jTime);
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsrec() {
		return this.isrec;
	}

	public void setIsrec(String isrec) {
		this.isrec = isrec;
	}

	public Date getjDate() {
		return this.jDate;
	}

	public void setjDate(Date jDate) {
		this.jDate = jDate;
	}

	public Time getjTime() {
		return this.jTime;
	}

	public void setjTime(Time jTime) {
		this.jTime = jTime;
	}

	public String getEdit() {
		return this.edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getEditdate() {
		return this.editdate;
	}

	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}

	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

	@Override
	public String toString() {
		return "TxtVO [rno=" + rno + ", mno=" + mno + ", txtno=" + txtno + ", count=" + count + ", rnum=" + rnum
				+ ", catno=" + catno + ", upno=" + upno + ", step=" + step + ", reno=" + reno + ", title=" + title
				+ ", mid=" + mid + ", mname=" + mname + ", mtxt=" + mtxt + ", cdate=" + cdate + ", category=" + category
				+ ", isrec=" + isrec + ", edit=" + edit + ", editdate=" + editdate + ", jDate=" + jDate + ", jTime="
				+ jTime + "]";
	}
	

}