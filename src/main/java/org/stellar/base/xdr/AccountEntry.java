// Automatically generated on 2015-07-21T12:54:49-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct AccountEntry
//  {
//      AccountID accountID;      // master public key for this account
//      int64 balance;            // in stroops
//      SequenceNumber seqNum;    // last sequence number used for this account
//      uint32 numSubEntries;     // number of sub-entries this account has
//                                // drives the reserve
//      AccountID* inflationDest; // Account to vote during inflation
//      uint32 flags;             // see AccountFlags
//  
//      string32 homeDomain; // can be used for reverse federation and memo lookup
//  
//      // fields used for signatures
//      // thresholds stores unsigned bytes: [weight of master|low|medium|high]
//      Thresholds thresholds;
//  
//      Signer signers<20>; // possible signers for this account
//  
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class AccountEntry  {
  public AccountEntry () {}
  private AccountID accountID;
  public AccountID getaccountID() {
    return this.accountID;
  }
  public void setaccountID(AccountID value) {
    this.accountID = value;
  }
  private Int64 balance;
  public Int64 getbalance() {
    return this.balance;
  }
  public void setbalance(Int64 value) {
    this.balance = value;
  }
  private SequenceNumber seqNum;
  public SequenceNumber getseqNum() {
    return this.seqNum;
  }
  public void setseqNum(SequenceNumber value) {
    this.seqNum = value;
  }
  private Uint32 numSubEntries;
  public Uint32 getnumSubEntries() {
    return this.numSubEntries;
  }
  public void setnumSubEntries(Uint32 value) {
    this.numSubEntries = value;
  }
  private AccountID inflationDest;
  public AccountID getinflationDest() {
    return this.inflationDest;
  }
  public void setinflationDest(AccountID value) {
    this.inflationDest = value;
  }
  private Uint32 flags;
  public Uint32 getflags() {
    return this.flags;
  }
  public void setflags(Uint32 value) {
    this.flags = value;
  }
  private String32 homeDomain;
  public String32 gethomeDomain() {
    return this.homeDomain;
  }
  public void sethomeDomain(String32 value) {
    this.homeDomain = value;
  }
  private Thresholds thresholds;
  public Thresholds getthresholds() {
    return this.thresholds;
  }
  public void setthresholds(Thresholds value) {
    this.thresholds = value;
  }
  private Signer[] signers;
  public Signer[] getsigners() {
    return this.signers;
  }
  public void setsigners(Signer[] value) {
    this.signers = value;
  }
  private AccountEntryExt ext;
  public AccountEntryExt getext() {
    return this.ext;
  }
  public void setext(AccountEntryExt value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, AccountEntry encodedAccountEntry) throws IOException{
    AccountID.encode(stream, encodedAccountEntry.accountID);
    Int64.encode(stream, encodedAccountEntry.balance);
    SequenceNumber.encode(stream, encodedAccountEntry.seqNum);
    Uint32.encode(stream, encodedAccountEntry.numSubEntries);
    if (encodedAccountEntry.inflationDest != null) {
    stream.writeInt(1);
    AccountID.encode(stream, encodedAccountEntry.inflationDest);
    } else {
    stream.writeInt(0);
    }
    Uint32.encode(stream, encodedAccountEntry.flags);
    String32.encode(stream, encodedAccountEntry.homeDomain);
    Thresholds.encode(stream, encodedAccountEntry.thresholds);
    int signerssize = encodedAccountEntry.getsigners().length;
    stream.writeInt(signerssize);
    for (int i = 0; i < signerssize; i++) {
      Signer.encode(stream, encodedAccountEntry.signers[i]);
    }
    AccountEntryExt.encode(stream, encodedAccountEntry.ext);
  }
  public static AccountEntry decode(XdrDataInputStream stream) throws IOException {
    AccountEntry decodedAccountEntry = new AccountEntry();
    decodedAccountEntry.accountID = AccountID.decode(stream);
    decodedAccountEntry.balance = Int64.decode(stream);
    decodedAccountEntry.seqNum = SequenceNumber.decode(stream);
    decodedAccountEntry.numSubEntries = Uint32.decode(stream);
    int inflationDestPresent = stream.readInt();
    if (inflationDestPresent != 0) {
    decodedAccountEntry.inflationDest = AccountID.decode(stream);
    }
    decodedAccountEntry.flags = Uint32.decode(stream);
    decodedAccountEntry.homeDomain = String32.decode(stream);
    decodedAccountEntry.thresholds = Thresholds.decode(stream);
    int signerssize = stream.readInt();
    decodedAccountEntry.signers = new Signer[signerssize];
    for (int i = 0; i < signerssize; i++) {
      decodedAccountEntry.signers[i] = Signer.decode(stream);
    }
    decodedAccountEntry.ext = AccountEntryExt.decode(stream);
    return decodedAccountEntry;
  }

  public static class AccountEntryExt {
    public AccountEntryExt () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }
    public static void encode(XdrDataOutputStream stream, AccountEntryExt encodedAccountEntryExt) throws IOException {
    stream.writeInt(encodedAccountEntryExt.getDiscriminant().intValue());
    switch (encodedAccountEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public static AccountEntryExt decode(XdrDataInputStream stream) throws IOException {
      AccountEntryExt decodedAccountEntryExt = new AccountEntryExt();
      switch (decodedAccountEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedAccountEntryExt;
    }

  }
}
