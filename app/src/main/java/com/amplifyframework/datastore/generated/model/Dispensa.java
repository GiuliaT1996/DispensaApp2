package com.amplifyframework.datastore.generated.model;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the Dispensa type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Dispensas", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Dispensa implements Model {
  public static final QueryField ID = field("Dispensa", "id");
  public static final QueryField NAME = field("Dispensa", "Name");
  public static final QueryField TRIGGER = field("Dispensa", "Trigger");
  public static final QueryField QUANTITY = field("Dispensa", "Quantity");
  public static final QueryField SECTION = field("Dispensa", "Section");
  public static final QueryField DATA_SCADENZA = field("Dispensa", "DataScadenza");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Name;
  private final @ModelField(targetType="Int", isRequired = true) Integer Trigger;
  private final @ModelField(targetType="Int", isRequired = true) Integer Quantity;
  private final @ModelField(targetType="String") String Section;
  private final @ModelField(targetType="AWSDate") Temporal.Date DataScadenza;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return Name;
  }
  
  public Integer getTrigger() {
      return Trigger;
  }
  
  public Integer getQuantity() {
      return Quantity;
  }
  
  public String getSection() {
      return Section;
  }
  
  public Temporal.Date getDataScadenza() {
      return DataScadenza;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Dispensa(String id, String Name, Integer Trigger, Integer Quantity, String Section, Temporal.Date DataScadenza) {
    this.id = id;
    this.Name = Name;
    this.Trigger = Trigger;
    this.Quantity = Quantity;
    this.Section = Section;
    this.DataScadenza = DataScadenza;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Dispensa dispensa = (Dispensa) obj;
      return ObjectsCompat.equals(getId(), dispensa.getId()) &&
              ObjectsCompat.equals(getName(), dispensa.getName()) &&
              ObjectsCompat.equals(getTrigger(), dispensa.getTrigger()) &&
              ObjectsCompat.equals(getQuantity(), dispensa.getQuantity()) &&
              ObjectsCompat.equals(getSection(), dispensa.getSection()) &&
              ObjectsCompat.equals(getDataScadenza(), dispensa.getDataScadenza()) &&
              ObjectsCompat.equals(getCreatedAt(), dispensa.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), dispensa.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getTrigger())
      .append(getQuantity())
      .append(getSection())
      .append(getDataScadenza())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Dispensa {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Name=" + String.valueOf(getName()) + ", ")
      .append("Trigger=" + String.valueOf(getTrigger()) + ", ")
      .append("Quantity=" + String.valueOf(getQuantity()) + ", ")
      .append("Section=" + String.valueOf(getSection()) + ", ")
      .append("DataScadenza=" + String.valueOf(getDataScadenza()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Dispensa justId(String id) {
    return new Dispensa(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Name,
      Trigger,
      Quantity,
      Section,
      DataScadenza);
  }
  public interface NameStep {
    TriggerStep name(String name);
  }
  

  public interface TriggerStep {
    QuantityStep trigger(Integer trigger);
  }
  

  public interface QuantityStep {
    BuildStep quantity(Integer quantity);
  }
  

  public interface BuildStep {
    Dispensa build();
    BuildStep id(String id);
    BuildStep section(String section);
    BuildStep dataScadenza(Temporal.Date dataScadenza);
  }
  

  public static class Builder implements NameStep, TriggerStep, QuantityStep, BuildStep {
    private String id;
    private String Name;
    private Integer Trigger;
    private Integer Quantity;
    private String Section;
    private Temporal.Date DataScadenza;
    @Override
     public Dispensa build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Dispensa(
          id,
          Name,
          Trigger,
          Quantity,
          Section,
          DataScadenza);
    }
    
    @Override
     public TriggerStep name(String name) {
        Objects.requireNonNull(name);
        this.Name = name;
        return this;
    }
    
    @Override
     public QuantityStep trigger(Integer trigger) {
        Objects.requireNonNull(trigger);
        this.Trigger = trigger;
        return this;
    }
    
    @Override
     public BuildStep quantity(Integer quantity) {
        Objects.requireNonNull(quantity);
        this.Quantity = quantity;
        return this;
    }
    
    @Override
     public BuildStep section(String section) {
        this.Section = section;
        return this;
    }
    
    @Override
     public BuildStep dataScadenza(Temporal.Date dataScadenza) {
        this.DataScadenza = dataScadenza;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, Integer trigger, Integer quantity, String section, Temporal.Date dataScadenza) {
      super.id(id);
      super.name(name)
        .trigger(trigger)
        .quantity(quantity)
        .section(section)
        .dataScadenza(dataScadenza);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder trigger(Integer trigger) {
      return (CopyOfBuilder) super.trigger(trigger);
    }
    
    @Override
     public CopyOfBuilder quantity(Integer quantity) {
      return (CopyOfBuilder) super.quantity(quantity);
    }
    
    @Override
     public CopyOfBuilder section(String section) {
      return (CopyOfBuilder) super.section(section);
    }
    
    @Override
     public CopyOfBuilder dataScadenza(Temporal.Date dataScadenza) {
      return (CopyOfBuilder) super.dataScadenza(dataScadenza);
    }
  }
  
}
