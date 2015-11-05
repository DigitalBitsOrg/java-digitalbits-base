// Automatically generated on 2015-11-05T11:21:06-08:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union LedgerKey switch (LedgerEntryType type)
//  {
//  case ACCOUNT:
//      struct
//      {
//          AccountID accountID;
//      } account;
//  
//  case TRUSTLINE:
//      struct
//      {
//          AccountID accountID;
//          Asset asset;
//      } trustLine;
//  
//  case OFFER:
//      struct
//      {
//          AccountID sellerID;
//          uint64 offerID;
//      } offer;
//  };

//  ===========================================================================
public class LedgerKey  {
  public LedgerKey () {}
  LedgerEntryType type;
  public LedgerEntryType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(LedgerEntryType value) {
    this.type = value;
  }
  private LedgerKeyAccount account;
  public LedgerKeyAccount getaccount() {
    return this.account;
  }
  public void setaccount(LedgerKeyAccount value) {
    this.account = value;
  }
  private LedgerKeyTrustLine trustLine;
  public LedgerKeyTrustLine gettrustLine() {
    return this.trustLine;
  }
  public void settrustLine(LedgerKeyTrustLine value) {
    this.trustLine = value;
  }
  private LedgerKeyOffer offer;
  public LedgerKeyOffer getoffer() {
    return this.offer;
  }
  public void setoffer(LedgerKeyOffer value) {
    this.offer = value;
  }
  public static void encode(XdrDataOutputStream stream, LedgerKey encodedLedgerKey) throws IOException {
  stream.writeInt(encodedLedgerKey.getDiscriminant().getValue());
  switch (encodedLedgerKey.getDiscriminant()) {
  case ACCOUNT:
  LedgerKeyAccount.encode(stream, encodedLedgerKey.account);
  break;
  case TRUSTLINE:
  LedgerKeyTrustLine.encode(stream, encodedLedgerKey.trustLine);
  break;
  case OFFER:
  LedgerKeyOffer.encode(stream, encodedLedgerKey.offer);
  break;
  }
  }
  public static LedgerKey decode(XdrDataInputStream stream) throws IOException {
    LedgerKey decodedLedgerKey = new LedgerKey();
    switch (decodedLedgerKey.getDiscriminant()) {
  case ACCOUNT:
  decodedLedgerKey.account = LedgerKeyAccount.decode(stream);
  break;
  case TRUSTLINE:
  decodedLedgerKey.trustLine = LedgerKeyTrustLine.decode(stream);
  break;
  case OFFER:
  decodedLedgerKey.offer = LedgerKeyOffer.decode(stream);
  break;
  }
    return decodedLedgerKey;
  }

  public static class LedgerKeyAccount {
    public LedgerKeyAccount () {}
    private AccountID accountID;
    public AccountID getaccountID() {
      return this.accountID;
    }
    public void setaccountID(AccountID value) {
      this.accountID = value;
    }
    public static void encode(XdrDataOutputStream stream, LedgerKeyAccount encodedLedgerKeyAccount) throws IOException{
      AccountID.encode(stream, encodedLedgerKeyAccount.accountID);
    }
    public static LedgerKeyAccount decode(XdrDataInputStream stream) throws IOException {
      LedgerKeyAccount decodedLedgerKeyAccount = new LedgerKeyAccount();
      decodedLedgerKeyAccount.accountID = AccountID.decode(stream);
      return decodedLedgerKeyAccount;
    }

  }
  public static class LedgerKeyTrustLine {
    public LedgerKeyTrustLine () {}
    private AccountID accountID;
    public AccountID getaccountID() {
      return this.accountID;
    }
    public void setaccountID(AccountID value) {
      this.accountID = value;
    }
    private Asset asset;
    public Asset getasset() {
      return this.asset;
    }
    public void setasset(Asset value) {
      this.asset = value;
    }
    public static void encode(XdrDataOutputStream stream, LedgerKeyTrustLine encodedLedgerKeyTrustLine) throws IOException{
      AccountID.encode(stream, encodedLedgerKeyTrustLine.accountID);
      Asset.encode(stream, encodedLedgerKeyTrustLine.asset);
    }
    public static LedgerKeyTrustLine decode(XdrDataInputStream stream) throws IOException {
      LedgerKeyTrustLine decodedLedgerKeyTrustLine = new LedgerKeyTrustLine();
      decodedLedgerKeyTrustLine.accountID = AccountID.decode(stream);
      decodedLedgerKeyTrustLine.asset = Asset.decode(stream);
      return decodedLedgerKeyTrustLine;
    }

  }
  public static class LedgerKeyOffer {
    public LedgerKeyOffer () {}
    private AccountID sellerID;
    public AccountID getsellerID() {
      return this.sellerID;
    }
    public void setsellerID(AccountID value) {
      this.sellerID = value;
    }
    private Uint64 offerID;
    public Uint64 getofferID() {
      return this.offerID;
    }
    public void setofferID(Uint64 value) {
      this.offerID = value;
    }
    public static void encode(XdrDataOutputStream stream, LedgerKeyOffer encodedLedgerKeyOffer) throws IOException{
      AccountID.encode(stream, encodedLedgerKeyOffer.sellerID);
      Uint64.encode(stream, encodedLedgerKeyOffer.offerID);
    }
    public static LedgerKeyOffer decode(XdrDataInputStream stream) throws IOException {
      LedgerKeyOffer decodedLedgerKeyOffer = new LedgerKeyOffer();
      decodedLedgerKeyOffer.sellerID = AccountID.decode(stream);
      decodedLedgerKeyOffer.offerID = Uint64.decode(stream);
      return decodedLedgerKeyOffer;
    }

  }
}
