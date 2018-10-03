package io.digitalbits.base;

import io.digitalbits.base.xdr.MemoType;

import java.nio.charset.StandardCharsets;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents MEMO_TEXT.
 */
public class MemoText extends Memo {
  private String text;

  public MemoText(String text) {
    this.text = checkNotNull(text, "text cannot be null");

    int length = text.getBytes((StandardCharsets.UTF_8)).length;
    if (length > 28) {
      throw new MemoTooLongException("text must be <= 28 bytes. length=" + String.valueOf(length));
    }
  }

  public String getText() {
    return text;
  }

  @Override
  io.digitalbits.base.xdr.Memo toXdr() {
    io.digitalbits.base.xdr.Memo memo = new io.digitalbits.base.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_TEXT);
    memo.setText(text);
    return memo;
  }
}
