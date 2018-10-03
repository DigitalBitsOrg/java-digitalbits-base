package io.digitalbits.base;

import io.digitalbits.base.xdr.AccountID;
import io.digitalbits.base.xdr.AssetType;

/**
 * Represents all assets with codes 5-12 characters long.
 * @see <a href="https://developer.digitalbits.io/guides/concepts/assets.html" target="_blank">Assets</a>
 */
public class AssetTypeCreditAlphaNum12 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code Asset code
   * @param issuer Asset issuer
   */
  public AssetTypeCreditAlphaNum12(String code, KeyPair issuer) {
    super(code, issuer);
    if (code.length() < 5 || code.length() > 12) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  public String getType() {
    return "credit_alphanum12";
  }

  @Override
  public io.digitalbits.base.xdr.Asset toXdr() {
    io.digitalbits.base.xdr.Asset xdr = new io.digitalbits.base.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM12);
    io.digitalbits.base.xdr.Asset.AssetAlphaNum12 credit = new io.digitalbits.base.xdr.Asset.AssetAlphaNum12();
    credit.setAssetCode(Util.paddedByteArray(mCode, 12));
    AccountID accountID = new AccountID();
    accountID.setAccountID(mIssuer.getXdrPublicKey());
    credit.setIssuer(accountID);
    xdr.setAlphaNum12(credit);
    return xdr;
  }
}
