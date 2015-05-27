// Automatically generated on 2015-05-27T10:24:45-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum ChangeTrustResultCode
//  {
//      // codes considered as "success" for the operation
//      CHANGE_TRUST_SUCCESS = 0,
//      // codes considered as "failure" for the operation
//      CHANGE_TRUST_MALFORMED = -1,     // bad input
//      CHANGE_TRUST_NO_ISSUER = -2,     // could not find issuer
//      CHANGE_TRUST_INVALID_LIMIT = -3, // cannot drop limit below balance
//      CHANGE_TRUST_LOW_RESERVE = -4 // not enough funds to create a new trust line
//  };

//  ===========================================================================
public enum ChangeTrustResultCode  {
  CHANGE_TRUST_SUCCESS(0),
  CHANGE_TRUST_MALFORMED(-1),
  CHANGE_TRUST_NO_ISSUER(-2),
  CHANGE_TRUST_INVALID_LIMIT(-3),
  CHANGE_TRUST_LOW_RESERVE(-4),
  ;
  private int mValue;

  ChangeTrustResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static ChangeTrustResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return CHANGE_TRUST_SUCCESS;
      case -1: return CHANGE_TRUST_MALFORMED;
      case -2: return CHANGE_TRUST_NO_ISSUER;
      case -3: return CHANGE_TRUST_INVALID_LIMIT;
      case -4: return CHANGE_TRUST_LOW_RESERVE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, ChangeTrustResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
