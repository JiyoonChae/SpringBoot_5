package com.iu.sb5.board.qna;

import com.iu.sb5.board.BoardVO;

import lombok.Data;
@Data
public class QnaVO extends BoardVO{
	private long ref;
	private long step;
	private long depth;
}
