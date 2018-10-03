package io.digitalbits.base;

import org.apache.commons.codec.DecoderException;
import io.digitalbits.base.xdr.Memo;
import io.digitalbits.base.xdr.MemoType;

/**
 * Represents MEMO_RETURN.
 */
public class MemoReturnHash extends MemoHashAbstract {
  public MemoReturnHash(byte[] bytes) {
    super(bytes);
  }

  public MemoReturnHash(String hexString) throws DecoderException {
    super(hexString);
  }

  @Override
  Memo toXdr() {
    io.digitalbits.base.xdr.Memo memo = new io.digitalbits.base.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_RETURN);

    io.digitalbits.base.xdr.Hash hash = new io.digitalbits.base.xdr.Hash();
    hash.setHash(bytes);

    memo.setHash(hash);
    return memo;
  }
}
