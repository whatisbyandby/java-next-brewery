import { SimpleGrid, Button } from '@chakra-ui/react';
import axios from 'axios';
import Page from '../../components/Page';
import RecipeCard from '../../components/RecipeCard';
import { Recipe } from '../../types';
import { useRouter } from 'next/router';

export async function getServerSideProps() {
  const res = await axios.get('http://localhost:8080/api/1.0/recipe');
  const recipes = res.data;

  return {
    props: {
      recipes,
    },
  };
}

export default function Recipes({ recipes }: { recipes: Recipe[] }) {
  const router = useRouter();
  return (
    <>
      <Button
        colorScheme={'blue'}
        onClick={async () => await router.push('/recipes/new')}
      >
        New
      </Button>
      <SimpleGrid minChildWidth="300px" spacing="40px">
        {recipes.map((recipe, index) => (
          <RecipeCard key={index} recipe={recipe} />
        ))}
      </SimpleGrid>
    </>
  );
}
