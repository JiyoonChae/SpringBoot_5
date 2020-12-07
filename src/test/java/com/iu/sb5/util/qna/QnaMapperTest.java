package com.iu.sb5.util.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb5.board.qna.QnaMapper;
import com.iu.sb5.board.qna.QnaVO;
@SpringBootTest
class QnaMapperTest {
	@Autowired
	private QnaMapper qnaMapper;
	@Test
	void test() throws Exception {
		for(int i=0; i<100; i++) {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("qtitle"+i);
		qnaVO.setWriter("qwriter"+i);
		qnaVO.setContents("qcontents"+i);
		
		qnaMapper.setInsert(qnaVO);
		}
		
	}

}
