// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum AllowTrustResultCode
//  {
//      // codes considered as "success" for the operation
//      ALLOW_TRUST_SUCCESS = 0,
//      // codes considered as "failure" for the operation
//      ALLOW_TRUST_MALFORMED = -1,     // asset is not ASSET_TYPE_ALPHANUM
//      ALLOW_TRUST_NO_TRUST_LINE = -2, // trustor does not have a trustline
//                                      // source account does not require trust
//      ALLOW_TRUST_TRUST_NOT_REQUIRED = -3,
//      ALLOW_TRUST_CANT_REVOKE = -4 // source account can't revoke trust
//  };

//  ===========================================================================
public enum AllowTrustResultCode  {
  ALLOW_TRUST_SUCCESS(0),
  ALLOW_TRUST_MALFORMED(-1),
  ALLOW_TRUST_NO_TRUST_LINE(-2),
  ALLOW_TRUST_TRUST_NOT_REQUIRED(-3),
  ALLOW_TRUST_CANT_REVOKE(-4),
  ;
  private int mValue;

  AllowTrustResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static AllowTrustResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ALLOW_TRUST_SUCCESS;
      case -1: return ALLOW_TRUST_MALFORMED;
      case -2: return ALLOW_TRUST_NO_TRUST_LINE;
      case -3: return ALLOW_TRUST_TRUST_NOT_REQUIRED;
      case -4: return ALLOW_TRUST_CANT_REVOKE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, AllowTrustResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
