// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union Memo switch (MemoType type)
//  {
//  case MEMO_NONE:
//      void;
//  case MEMO_TEXT:
//      string text<28>;
//  case MEMO_ID:
//      uint64 id;
//  case MEMO_HASH:
//      Hash hash; // the hash of what to pull from the content server
//  case MEMO_RETURN:
//      Hash retHash; // the hash of the tx you are rejecting
//  };

//  ===========================================================================
public class Memo  {
  public Memo () {}
  MemoType type;
  public MemoType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(MemoType value) {
    this.type = value;
  }
  private String text;
  public String gettext() {
    return this.text;
  }
  public void settext(String value) {
    this.text = value;
  }
  private Uint64 id;
  public Uint64 getid() {
    return this.id;
  }
  public void setid(Uint64 value) {
    this.id = value;
  }
  private Hash hash;
  public Hash gethash() {
    return this.hash;
  }
  public void sethash(Hash value) {
    this.hash = value;
  }
  private Hash retHash;
  public Hash getretHash() {
    return this.retHash;
  }
  public void setretHash(Hash value) {
    this.retHash = value;
  }
  public static void encode(XdrDataOutputStream stream, Memo encodedMemo) throws IOException {
  stream.writeInt(encodedMemo.getDiscriminant().getValue());
  switch (encodedMemo.getDiscriminant()) {
  case MEMO_NONE:
  break;
  case MEMO_TEXT:
  stream.writeString(encodedMemo.text);
  break;
  case MEMO_ID:
  Uint64.encode(stream, encodedMemo.id);
  break;
  case MEMO_HASH:
  Hash.encode(stream, encodedMemo.hash);
  break;
  case MEMO_RETURN:
  Hash.encode(stream, encodedMemo.retHash);
  break;
  }
  }
  public static Memo decode(XdrDataInputStream stream) throws IOException {
    Memo decodedMemo = new Memo();
    switch (decodedMemo.getDiscriminant()) {
  case MEMO_NONE:
  break;
  case MEMO_TEXT:
  decodedMemo.text = stream.readString();
  break;
  case MEMO_ID:
  decodedMemo.id = Uint64.decode(stream);
  break;
  case MEMO_HASH:
  decodedMemo.hash = Hash.decode(stream);
  break;
  case MEMO_RETURN:
  decodedMemo.retHash = Hash.decode(stream);
  break;
  }
    return decodedMemo;
  }
}
