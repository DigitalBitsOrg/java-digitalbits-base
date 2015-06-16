// Automatically generated on 2015-06-16T15:35:11-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum LedgerEntryType
//  {
//      ACCOUNT = 0,
//      TRUSTLINE = 1,
//      OFFER = 2
//  };

//  ===========================================================================
public enum LedgerEntryType  {
  ACCOUNT(0),
  TRUSTLINE(1),
  OFFER(2),
  ;
  private int mValue;

  LedgerEntryType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static LedgerEntryType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ACCOUNT;
      case 1: return TRUSTLINE;
      case 2: return OFFER;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, LedgerEntryType value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
