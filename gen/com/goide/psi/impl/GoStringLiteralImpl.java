// This is a generated file. Not intended for manual editing.
package com.goide.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.goide.GoTypes.*;
import com.goide.psi.*;
import com.goide.util.GoStringLiteralEscaper;

public class GoStringLiteralImpl extends GoExpressionImpl implements GoStringLiteral {

  public GoStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GoVisitor) ((GoVisitor)visitor).visitStringLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getRawString() {
    return findChildByType(RAW_STRING);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  public boolean isValidHost() {
    return GoPsiImplUtil.isValidHost(this);
  }

  @NotNull
  public GoStringLiteralImpl updateText(String text) {
    return GoPsiImplUtil.updateText(this, text);
  }

  @NotNull
  public GoStringLiteralEscaper createLiteralTextEscaper() {
    return GoPsiImplUtil.createLiteralTextEscaper(this);
  }

}
