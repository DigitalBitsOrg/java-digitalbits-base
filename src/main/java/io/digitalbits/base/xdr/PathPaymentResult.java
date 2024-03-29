// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union PathPaymentResult switch (PathPaymentResultCode code)
//  {
//  case PATH_PAYMENT_SUCCESS:
//      struct
//      {
//          ClaimOfferAtom offers<>;
//          SimplePaymentResult last;
//      } success;
//  case PATH_PAYMENT_NO_ISSUER:
//      Asset noIssuer; // the asset that caused the error
//  default:
//      void;
//  };

//  ===========================================================================
public class PathPaymentResult  {
  public PathPaymentResult () {}
  PathPaymentResultCode code;
  public PathPaymentResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(PathPaymentResultCode value) {
    this.code = value;
  }
  private PathPaymentResultSuccess success;
  public PathPaymentResultSuccess getSuccess() {
    return this.success;
  }
  public void setSuccess(PathPaymentResultSuccess value) {
    this.success = value;
  }
  private Asset noIssuer;
  public Asset getNoIssuer() {
    return this.noIssuer;
  }
  public void setNoIssuer(Asset value) {
    this.noIssuer = value;
  }
  public static void encode(XdrDataOutputStream stream, PathPaymentResult encodedPathPaymentResult) throws IOException {
  stream.writeInt(encodedPathPaymentResult.getDiscriminant().getValue());
  switch (encodedPathPaymentResult.getDiscriminant()) {
  case PATH_PAYMENT_SUCCESS:
  PathPaymentResultSuccess.encode(stream, encodedPathPaymentResult.success);
  break;
  case PATH_PAYMENT_NO_ISSUER:
  Asset.encode(stream, encodedPathPaymentResult.noIssuer);
  break;
  default:
  break;
  }
  }
  public static PathPaymentResult decode(XdrDataInputStream stream) throws IOException {
    PathPaymentResult decodedPathPaymentResult = new PathPaymentResult();
    switch (decodedPathPaymentResult.getDiscriminant()) {
  case PATH_PAYMENT_SUCCESS:
  decodedPathPaymentResult.success = PathPaymentResultSuccess.decode(stream);
  break;
  case PATH_PAYMENT_NO_ISSUER:
  decodedPathPaymentResult.noIssuer = Asset.decode(stream);
  break;
  default:
  break;
  }
    return decodedPathPaymentResult;
  }

  public static class PathPaymentResultSuccess {
    public PathPaymentResultSuccess () {}
    private ClaimOfferAtom[] offers;
    public ClaimOfferAtom[] getOffers() {
      return this.offers;
    }
    public void setOffers(ClaimOfferAtom[] value) {
      this.offers = value;
    }
    private SimplePaymentResult last;
    public SimplePaymentResult getLast() {
      return this.last;
    }
    public void setLast(SimplePaymentResult value) {
      this.last = value;
    }
    public static void encode(XdrDataOutputStream stream, PathPaymentResultSuccess encodedPathPaymentResultSuccess) throws IOException{
      int offerssize = encodedPathPaymentResultSuccess.getOffers().length;
      stream.writeInt(offerssize);
      for (int i = 0; i < offerssize; i++) {
        ClaimOfferAtom.encode(stream, encodedPathPaymentResultSuccess.offers[i]);
      }
      SimplePaymentResult.encode(stream, encodedPathPaymentResultSuccess.last);
    }
    public static PathPaymentResultSuccess decode(XdrDataInputStream stream) throws IOException {
      PathPaymentResultSuccess decodedPathPaymentResultSuccess = new PathPaymentResultSuccess();
      int offerssize = stream.readInt();
      decodedPathPaymentResultSuccess.offers = new ClaimOfferAtom[offerssize];
      for (int i = 0; i < offerssize; i++) {
        decodedPathPaymentResultSuccess.offers[i] = ClaimOfferAtom.decode(stream);
      }
      decodedPathPaymentResultSuccess.last = SimplePaymentResult.decode(stream);
      return decodedPathPaymentResultSuccess;
    }

  }
}
