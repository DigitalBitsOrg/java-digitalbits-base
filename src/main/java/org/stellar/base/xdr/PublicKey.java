// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union PublicKey switch (CryptoKeyType type)
//  {
//  case KEY_TYPE_ED25519:
//      uint256 ed25519;
//  };

//  ===========================================================================
public class PublicKey  {
  public PublicKey () {}
  CryptoKeyType type;
  public CryptoKeyType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(CryptoKeyType value) {
    this.type = value;
  }
  private Uint256 ed25519;
  public Uint256 geted25519() {
    return this.ed25519;
  }
  public void seted25519(Uint256 value) {
    this.ed25519 = value;
  }
  public static void encode(XdrDataOutputStream stream, PublicKey encodedPublicKey) throws IOException {
  stream.writeInt(encodedPublicKey.getDiscriminant().getValue());
  switch (encodedPublicKey.getDiscriminant()) {
  case KEY_TYPE_ED25519:
  Uint256.encode(stream, encodedPublicKey.ed25519);
  break;
  }
  }
  public static PublicKey decode(XdrDataInputStream stream) throws IOException {
    PublicKey decodedPublicKey = new PublicKey();
    switch (decodedPublicKey.getDiscriminant()) {
  case KEY_TYPE_ED25519:
  decodedPublicKey.ed25519 = Uint256.decode(stream);
  break;
  }
    return decodedPublicKey;
  }
}
