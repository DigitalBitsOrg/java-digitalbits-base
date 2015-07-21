// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union AllowTrustResult switch (AllowTrustResultCode code)
//  {
//  case ALLOW_TRUST_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class AllowTrustResult  {
  public AllowTrustResult () {}
  AllowTrustResultCode code;
  public AllowTrustResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(AllowTrustResultCode value) {
    this.code = value;
  }
  public static void encode(XdrDataOutputStream stream, AllowTrustResult encodedAllowTrustResult) throws IOException {
  stream.writeInt(encodedAllowTrustResult.getDiscriminant().getValue());
  switch (encodedAllowTrustResult.getDiscriminant()) {
  case ALLOW_TRUST_SUCCESS:
  break;
  default:
  break;
  }
  }
  public static AllowTrustResult decode(XdrDataInputStream stream) throws IOException {
    AllowTrustResult decodedAllowTrustResult = new AllowTrustResult();
    switch (decodedAllowTrustResult.getDiscriminant()) {
  case ALLOW_TRUST_SUCCESS:
  break;
  default:
  break;
  }
    return decodedAllowTrustResult;
  }
}
