package com.goide.psi.impl;

import com.goide.psi.GoCompositeElement;
import com.goide.psi.GoNamedElement;
import com.goide.psi.GoType;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class GoNamedElementImpl extends GoCompositeElementImpl implements GoCompositeElement, GoNamedElement {
  public GoNamedElementImpl(ASTNode node) {
    super(node);
  }

  public boolean isPublic() {
    return StringUtil.isCapitalized(getName());
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    return getIdentifier();
  }

  @Nullable
  @Override
  public String getName() {
    PsiElement identifier = getIdentifier();
    return identifier != null ? identifier.getText() : null;
  }

  @Override
  public int getTextOffset() {
    PsiElement identifier = getIdentifier();
    return identifier != null ? identifier.getTextOffset() : 0;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String newName) throws IncorrectOperationException {
    PsiElement identifier = getIdentifier();
    if (identifier != null) {
      identifier.replace(GoElementFactory.createIdentifierFromText(getProject(), newName));
    }
    return this;
  }

  @Nullable
  @Override
  public GoType getGoType() {
    return getType(this);
  }

  @Nullable
  public static GoType getType(GoNamedElement o) {
    return PsiTreeUtil.getNextSiblingOfType(o, GoType.class);
  }
}