// Automatically generated on 2015-07-21T12:54:49-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum OfferEntryFlags
//  {
//      // issuer has authorized account to perform transactions with its credit
//      PASSIVE_FLAG = 1
//  };

//  ===========================================================================
public enum OfferEntryFlags  {
  PASSIVE_FLAG(1),
  ;
  private int mValue;

  OfferEntryFlags(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static OfferEntryFlags decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 1: return PASSIVE_FLAG;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, OfferEntryFlags value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
