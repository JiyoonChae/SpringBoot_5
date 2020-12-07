package com.iu.sb5.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb5.board.BoardVO;
import com.iu.sb5.board.notice.NoticeMapper;
@SpringBootTest
class PagerTest {
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void test() throws Exception {
		Pager pager = new Pager();
		pager.setStartRow(10);
		pager.setPerPage(10);
		List<BoardVO>ar = noticeMapper.getList(pager);
		assertEquals(10, ar.size());
	}

}
