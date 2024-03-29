// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum LedgerEntryChangeType
//  {
//      LEDGER_ENTRY_CREATED = 0, // entry was added to the ledger
//      LEDGER_ENTRY_UPDATED = 1, // entry was modified in the ledger
//      LEDGER_ENTRY_REMOVED = 2  // entry was removed from the ledger
//  };

//  ===========================================================================
public enum LedgerEntryChangeType  {
  LEDGER_ENTRY_CREATED(0),
  LEDGER_ENTRY_UPDATED(1),
  LEDGER_ENTRY_REMOVED(2),
  ;
  private int mValue;

  LedgerEntryChangeType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static LedgerEntryChangeType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return LEDGER_ENTRY_CREATED;
      case 1: return LEDGER_ENTRY_UPDATED;
      case 2: return LEDGER_ENTRY_REMOVED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, LedgerEntryChangeType value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
