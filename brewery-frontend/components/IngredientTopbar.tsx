import { ReactNode } from 'react';
import {
  Box,
  Flex,
  Avatar,
  HStack,
  Link,
  useColorModeValue,
  Stack,
} from '@chakra-ui/react';

import NextLink from 'next/link';

const Links = [
  { title: 'Fermentables', path: '/ingredients/fermentable' },
  { title: 'Hops', path: '/ingredients/hop' },
  { title: 'Yeast', path: '/ingredients/yeast' },
];

const NavLink = ({ path, title }: { path: string; title: string }) => (
  <NextLink href={path} passHref>
    <Link
      px={2}
      py={1}
      rounded={'md'}
      _hover={{
        textDecoration: 'none',
        bg: useColorModeValue('gray.200', 'gray.700'),
      }}
      href={path}
    >
      {title}
    </Link>
  </NextLink>
);

export default function IngredientTopbar() {
  return (
    <>
      <Box bg={useColorModeValue('gray.100', 'gray.900')}>
        <Flex h={16} alignItems={'center'} justifyContent={'space-between'}>
          <HStack spacing={8} alignItems={'center'}>
            <HStack
              as={'nav'}
              spacing={4}
              display={{ base: 'none', md: 'flex' }}
            >
              {Links.map((link) => (
                <NavLink key={link.title} path={link.path} title={link.title} />
              ))}
            </HStack>
          </HStack>
        </Flex>
      </Box>
    </>
  );
}
