import { Container } from '@chakra-ui/react';
import Page from '../../components/Page';
import RecipeForm from '../../components/RecipeForm';
import { Recipe } from '../../types';

export default function NewRecipe() {
  const recipe: Recipe = {
    id: 0,
    name: '',
    author: '',
    description: '',
    recipeType: '',
    ingredients: [],
  };

  return (
    <Container maxW={'100%'} padding={2}>
      <RecipeForm recipe={recipe} />
    </Container>
  );
}
