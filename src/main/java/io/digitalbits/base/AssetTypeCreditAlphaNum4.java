package io.digitalbits.base;

import io.digitalbits.base.xdr.AccountID;
import io.digitalbits.base.xdr.AssetType;

/**
 * Represents all assets with codes 1-4 characters long.
 * @see <a href="https://developer.digitalbits.io/guides/concepts/assets.html" target="_blank">Assets</a>
 */
public class AssetTypeCreditAlphaNum4 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code Asset code
   * @param issuer Asset issuer
   */
  public AssetTypeCreditAlphaNum4(String code, KeyPair issuer) {
    super(code, issuer);
    if (code.length() < 1 || code.length() > 4) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  public String getType() {
    return "credit_alphanum4";
  }

  @Override
  public io.digitalbits.base.xdr.Asset toXdr() {
    io.digitalbits.base.xdr.Asset xdr = new io.digitalbits.base.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM4);
    io.digitalbits.base.xdr.Asset.AssetAlphaNum4 credit = new io.digitalbits.base.xdr.Asset.AssetAlphaNum4();
    credit.setAssetCode(Util.paddedByteArray(mCode, 4));
    AccountID accountID = new AccountID();
    accountID.setAccountID(mIssuer.getXdrPublicKey());
    credit.setIssuer(accountID);
    xdr.setAlphaNum4(credit);
    return xdr;
  }
}
