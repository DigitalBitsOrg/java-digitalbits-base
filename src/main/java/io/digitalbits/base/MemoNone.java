package io.digitalbits.base;

import io.digitalbits.base.xdr.MemoType;

/**
 * Represents MEMO_NONE.
 */
public class MemoNone extends Memo {
  @Override
  io.digitalbits.base.xdr.Memo toXdr() {
    io.digitalbits.base.xdr.Memo memo = new io.digitalbits.base.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_NONE);
    return memo;
  }
}
