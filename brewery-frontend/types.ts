export interface Recipe {
  id: number;
  name: string;
  author: string;
  description: string;
  recipeType: string;
  ingredients: IngredientAddition[];
}

export interface IngredientAddition {
  ingredient: Ingredient;
  amount: number;
}

export interface Ingredient {
  id: number;
  name: string;
  supplier: string;
  origin: string;
}

export interface Fermentable extends Ingredient {
  fermentableType: string;
  color: number;
  potential: number;
  yield: number;
  diastaticPower: number;
}

export enum HopType {
  PELLET = 'PELLET',
  WHOLE = 'WHOLE',
  CRYO = 'CRYO',
  CO2_EXTRACT = 'CO2_EXTRACT',
}

export interface Hop extends Ingredient {
  hopType: HopType;
  alphaAcid: number;
}

export enum YeastType {
  ALE = 'ALE',
  LAGER = 'LAGER',
  HYBRID = 'HYBRID',
  WHEAT = 'WHEAT',
  WINE = 'WINE',
  CHAMPAGNE = 'CHAMPAGNE',
  OTHER = 'OTHER',
}

export interface Yeast extends Ingredient {
  attenuation: number;
  yeastType: YeastType;
  minimumTemperature: number;
  maximumTemperature: number;
  minimumAttenuation: number;
  maximumAttenuation: number;
  maximumABV: number;
}

export interface Miscellaneous extends Ingredient {
  use: string;
  miscType: string;
}
