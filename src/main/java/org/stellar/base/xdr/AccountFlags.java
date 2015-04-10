// Automatically generated on 2015-04-10T00:48:12-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum AccountFlags
//  { // masks for each flag
//      AUTH_REQUIRED_FLAG = 0x1
//  };

//  ===========================================================================
public enum AccountFlags  {
  AUTH_REQUIRED_FLAG(1),
  ;
  private int mValue;

  AccountFlags(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static AccountFlags decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 1: return AUTH_REQUIRED_FLAG;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, AccountFlags value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
