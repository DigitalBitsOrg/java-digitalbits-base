// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum PaymentResultCode
//  {
//      // codes considered as "success" for the operation
//      PAYMENT_SUCCESS = 0, // payment successfuly completed
//  
//      // codes considered as "failure" for the operation
//      PAYMENT_MALFORMED = -1,          // bad input
//      PAYMENT_UNDERFUNDED = -2,        // not enough funds in source account
//      PAYMENT_SRC_NO_TRUST = -3,       // no trust line on source account
//      PAYMENT_SRC_NOT_AUTHORIZED = -4, // source not authorized to transfer
//      PAYMENT_NO_DESTINATION = -5,     // destination account does not exist
//      PAYMENT_NO_TRUST = -6, // destination missing a trust line for asset
//      PAYMENT_NOT_AUTHORIZED = -7, // destination not authorized to hold asset
//      PAYMENT_LINE_FULL = -8       // destination would go above their limit
//  };

//  ===========================================================================
public enum PaymentResultCode  {
  PAYMENT_SUCCESS(0),
  PAYMENT_MALFORMED(-1),
  PAYMENT_UNDERFUNDED(-2),
  PAYMENT_SRC_NO_TRUST(-3),
  PAYMENT_SRC_NOT_AUTHORIZED(-4),
  PAYMENT_NO_DESTINATION(-5),
  PAYMENT_NO_TRUST(-6),
  PAYMENT_NOT_AUTHORIZED(-7),
  PAYMENT_LINE_FULL(-8),
  ;
  private int mValue;

  PaymentResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static PaymentResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return PAYMENT_SUCCESS;
      case -1: return PAYMENT_MALFORMED;
      case -2: return PAYMENT_UNDERFUNDED;
      case -3: return PAYMENT_SRC_NO_TRUST;
      case -4: return PAYMENT_SRC_NOT_AUTHORIZED;
      case -5: return PAYMENT_NO_DESTINATION;
      case -6: return PAYMENT_NO_TRUST;
      case -7: return PAYMENT_NOT_AUTHORIZED;
      case -8: return PAYMENT_LINE_FULL;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, PaymentResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
