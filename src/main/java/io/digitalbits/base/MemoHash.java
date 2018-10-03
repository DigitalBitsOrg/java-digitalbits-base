package io.digitalbits.base;

import org.apache.commons.codec.DecoderException;
import io.digitalbits.base.xdr.MemoType;

/**
 * Represents MEMO_HASH.
 */
public class MemoHash extends MemoHashAbstract {
  public MemoHash(byte[] bytes) {
    super(bytes);
  }

  public MemoHash(String hexString) throws DecoderException {
    super(hexString);
  }

  @Override
  io.digitalbits.base.xdr.Memo toXdr() {
    io.digitalbits.base.xdr.Memo memo = new io.digitalbits.base.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_HASH);

    io.digitalbits.base.xdr.Hash hash = new io.digitalbits.base.xdr.Hash();
    hash.setHash(bytes);

    memo.setHash(hash);
    return memo;
  }
}
