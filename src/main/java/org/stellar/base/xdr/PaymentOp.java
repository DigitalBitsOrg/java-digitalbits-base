// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct PaymentOp
//  {
//      AccountID destination; // recipient of the payment
//      Asset asset;     // what they end up with
//      int64 amount;          // amount they end up with
//  };

//  ===========================================================================
public class PaymentOp  {
  public PaymentOp () {}
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
  public static void encode(XdrDataOutputStream stream, PaymentOp encodedPaymentOp) throws IOException{
    AccountID.encode(stream, encodedPaymentOp.destination);
    Asset.encode(stream, encodedPaymentOp.asset);
    Int64.encode(stream, encodedPaymentOp.amount);
  }
  public static PaymentOp decode(XdrDataInputStream stream) throws IOException {
    PaymentOp decodedPaymentOp = new PaymentOp();
    decodedPaymentOp.destination = AccountID.decode(stream);
    decodedPaymentOp.asset = Asset.decode(stream);
    decodedPaymentOp.amount = Int64.decode(stream);
    return decodedPaymentOp;
  }
}
