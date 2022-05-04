import { Container } from '@chakra-ui/react';
import Page from '../../components/Page';
import RecipeForm from '../../components/RecipeForm';
import { Recipe } from '../../types';
import axios from 'axios';

export async function getServerSideProps({ params }: any) {
  const res = await axios.get(
    `http://localhost:8080/api/1.0/recipe/${params.id}`
  );

  return {
    props: {
      recipe: res.data,
    },
  };
}

export default function EditRecipe({ recipe }: { recipe: Recipe }) {
  return (
    <Container maxW={'100%'} padding={2}>
      <RecipeForm recipe={recipe} />
    </Container>
  );
}
