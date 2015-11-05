// Automatically generated on 2015-11-05T11:21:06-08:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct TransactionHistoryResultEntry
//  {
//      uint32 ledgerSeq;
//      TransactionResultSet txResultSet;
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
public class TransactionHistoryResultEntry  {
  public TransactionHistoryResultEntry () {}
  private Uint32 ledgerSeq;
  public Uint32 getledgerSeq() {
    return this.ledgerSeq;
  }
  public void setledgerSeq(Uint32 value) {
    this.ledgerSeq = value;
  }
  private TransactionResultSet txResultSet;
  public TransactionResultSet gettxResultSet() {
    return this.txResultSet;
  }
  public void settxResultSet(TransactionResultSet value) {
    this.txResultSet = value;
  }
  private TransactionHistoryResultEntryExt ext;
  public TransactionHistoryResultEntryExt getext() {
    return this.ext;
  }
  public void setext(TransactionHistoryResultEntryExt value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, TransactionHistoryResultEntry encodedTransactionHistoryResultEntry) throws IOException{
    Uint32.encode(stream, encodedTransactionHistoryResultEntry.ledgerSeq);
    TransactionResultSet.encode(stream, encodedTransactionHistoryResultEntry.txResultSet);
    TransactionHistoryResultEntryExt.encode(stream, encodedTransactionHistoryResultEntry.ext);
  }
  public static TransactionHistoryResultEntry decode(XdrDataInputStream stream) throws IOException {
    TransactionHistoryResultEntry decodedTransactionHistoryResultEntry = new TransactionHistoryResultEntry();
    decodedTransactionHistoryResultEntry.ledgerSeq = Uint32.decode(stream);
    decodedTransactionHistoryResultEntry.txResultSet = TransactionResultSet.decode(stream);
    decodedTransactionHistoryResultEntry.ext = TransactionHistoryResultEntryExt.decode(stream);
    return decodedTransactionHistoryResultEntry;
  }

  public static class TransactionHistoryResultEntryExt {
    public TransactionHistoryResultEntryExt () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }
    public static void encode(XdrDataOutputStream stream, TransactionHistoryResultEntryExt encodedTransactionHistoryResultEntryExt) throws IOException {
    stream.writeInt(encodedTransactionHistoryResultEntryExt.getDiscriminant().intValue());
    switch (encodedTransactionHistoryResultEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public static TransactionHistoryResultEntryExt decode(XdrDataInputStream stream) throws IOException {
      TransactionHistoryResultEntryExt decodedTransactionHistoryResultEntryExt = new TransactionHistoryResultEntryExt();
      switch (decodedTransactionHistoryResultEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedTransactionHistoryResultEntryExt;
    }

  }
}
