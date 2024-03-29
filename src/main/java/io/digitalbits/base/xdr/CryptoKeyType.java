// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum CryptoKeyType
//  {
//      KEY_TYPE_ED25519 = 0
//  };

//  ===========================================================================
public enum CryptoKeyType  {
  KEY_TYPE_ED25519(0),
  ;
  private int mValue;

  CryptoKeyType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static CryptoKeyType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return KEY_TYPE_ED25519;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, CryptoKeyType value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
