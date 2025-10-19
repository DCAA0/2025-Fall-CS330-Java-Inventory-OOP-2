package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable {
    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(src.name);

        this.durability = src.durability;
        this.material = src.material;
        this.modifier = src.modifier;
        this.modifierLevel = src.modifierLevel;
        this.element = src.element;
        this.defense = src.defense;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        super.material = snr.next();
        super.durability = snr.nextInt();
        this.defense = snr.nextInt();
        super.modifier = snr.next();
        super.modifierLevel = snr.nextInt();
        super.element = snr.next();

    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();

        cpy.setName(this.name);

        cpy.setDurability(this.getDurability());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        cpy.setElement(this.getElement());
        cpy.setDefense(this.defense);

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return this.name.equals(rhsItem.name) &&
            this.material.equals(rhsItem.material) &&
            this.modifier.equals(rhsItem.modifier) &&
            this.element.equals(rhsItem.element);

    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode()
    {
        // int hash = 17;

        // hash = 31 * hash + (name != null ? name.hashCode() : 0);
        // hash = 31 * hash + (material != null ? material.hashCode() : 0);
        // hash = 31 * hash + (modifier != null ? modifier.hashCode() : 0);
        // hash = 31 * hash + (element != null ? element.hashCode() : 0);
        
        // return hash;

        return name.hashCode() + material.hashCode() + modifier.hashCode() + element.hashCode();
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.join(
            System.lineSeparator(),
            String.format("  Nme: %s%n  Dur: %d%n  Def: %d%n  Mtl: %s%n  Mdr: %s (Lvl %d)%n  Emt: %s", 
                super.getName(), super.getDurability(), this.getDefense(), super.getMaterial(), super.getModifier(), super.getModifierLevel(), 
                super.getElement()),
            ""
        );
    }
}




