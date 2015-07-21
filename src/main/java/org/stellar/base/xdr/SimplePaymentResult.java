// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct SimplePaymentResult
//  {
//      AccountID destination;
//      Asset asset;
//      int64 amount;
//  };

//  ===========================================================================
public class SimplePaymentResult  {
  public SimplePaymentResult () {}
  private AccountID destination;
  public AccountID getdestination() {
    return this.destination;
  }
  public void setdestination(AccountID value) {
    this.destination = value;
  }
  private Asset asset;
  public Asset getasset() {
    return this.asset;
  }
  public void setasset(Asset value) {
    this.asset = value;
  }
  private Int64 amount;
  public Int64 getamount() {
    return this.amount;
  }
  public void setamount(Int64 value) {
    this.amount = value;
  }
  public static void encode(XdrDataOutputStream stream, SimplePaymentResult encodedSimplePaymentResult) throws IOException{
    AccountID.encode(stream, encodedSimplePaymentResult.destination);
    Asset.encode(stream, encodedSimplePaymentResult.asset);
    Int64.encode(stream, encodedSimplePaymentResult.amount);
  }
  public static SimplePaymentResult decode(XdrDataInputStream stream) throws IOException {
    SimplePaymentResult decodedSimplePaymentResult = new SimplePaymentResult();
    decodedSimplePaymentResult.destination = AccountID.decode(stream);
    decodedSimplePaymentResult.asset = Asset.decode(stream);
    decodedSimplePaymentResult.amount = Int64.decode(stream);
    return decodedSimplePaymentResult;
  }
}
