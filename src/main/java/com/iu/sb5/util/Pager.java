package com.iu.sb5.util;

import lombok.Data;

@Data
public class Pager {
	
	private String kind;
	private String search;
	
	
	private Integer curPage;
	private long perPage;
	private long startRow;
	
	private long totalCount;
	
	private long startNum;
	private long lastNum;
	
	private boolean isBefore;
	private boolean isAfter;
	
	public Pager() {
		this.perPage=10;
	}
	
	//한 페이지당 10개씩 출력하기위한 sql문
	public void makeRow() {
		System.out.println("3:"+ getCurPage());
		this.startRow = (this.getCurPage()-1)*perPage;
	
	}
	
	//나머지작업
	public void makePage(long totalCount) {
		System.out.println("TC:"+ getTotalCount());
		//전체 글 수를 가지고 전체 페이지 수 구하기
		long totalPage = totalCount/this.getPerPage();
		//전체글이 112였는데 한페이지당 10개출력 = 11.2 나옴. =>즉 12페이지 필요
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//전체 블록 수 구하기
		//총 12페이지가 나왔는데, 한 블록당 5개(1-5)를 보이고싶다~ 그럼 몇 블록필요? =3
		long perBlock=5;
		long totalBlock = totalPage / perBlock;
		//여기도 10페이지면 2블록이면 ok, but 12페이지니까 3블록필요.. +1해줘야함
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		System.out.println("4:"+ getCurPage());
		//curPage 값을 이용해서 현재 블록 구하기 ex)지금보는페이지가 3페이지야. 그럼 1블록에 있어야하고 7페이지면 2블록에 있어야하잖아
		//1-5페이지면 1블록, 6-10페이지면 2블록, 11-15페이지면 3블록인걸 식으로 구현해야하는거징.
		long curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock != 0){
			curBlock++;
		}
		
		//curBlock 값을 이용해서 startNum, lastNum 구하기
		//현재 7페이지, 2블록에 있다면 그 블록의 처음은 6, 마지막은10 
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock * perBlock;
		
		
		//만약에 현재 block이 마지막 block 이라면 
		if(curBlock ==totalBlock) {
			lastNum = totalPage;
		}
		
		//이전, 다음 기능 추가
		if(curBlock>1) {
			this.isBefore = true;
		}
		
		System.out.println("tb:"+ getTotalCount());
		if(curBlock<totalBlock) {
			this.isAfter=true;
		}
		
	
	}
	
	public Integer getCurPage() {
		if(curPage==null) {
			curPage=1;
		}
		return this.curPage;
	}
	
	public void setCurPage(Integer curPage) {
		if(curPage==0) {
			this.curPage=1;
		}else {
			this.curPage=curPage;
		}
	}
	
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return this.search;
	}
}
