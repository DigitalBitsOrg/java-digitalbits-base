// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum InflationResultCode
//  {
//      // codes considered as "success" for the operation
//      INFLATION_SUCCESS = 0,
//      // codes considered as "failure" for the operation
//      INFLATION_NOT_TIME = -1
//  };

//  ===========================================================================
public enum InflationResultCode  {
  INFLATION_SUCCESS(0),
  INFLATION_NOT_TIME(-1),
  ;
  private int mValue;

  InflationResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static InflationResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return INFLATION_SUCCESS;
      case -1: return INFLATION_NOT_TIME;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, InflationResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
