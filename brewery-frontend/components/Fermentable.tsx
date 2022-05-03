import { Fermentable } from '../types';
import {
  List,
  ListItem,
  ListIcon,
  Flex,
  Button,
  useDisclosure,
} from '@chakra-ui/react';
import { MdCheckCircle, MdSettings } from 'react-icons/md';
import FermentableAddition from './FermentableAddition';

export default function Fermentables({
  fermentableList,
}: {
  fermentableList: Fermentable[];
}) {
  const { isOpen, onClose, onOpen } = useDisclosure();
  return (
    <>
      <Flex
        justifyContent="space-between"
        alignContent={'center'}
        border="1px"
        borderColor="gray.200"
        borderRadius={'md'}
        mt={4}
      >
        <h6>Fermentables</h6>
        <Button onClick={() => onOpen()}>Add</Button>
      </Flex>
      <List spacing={3}>
        {fermentableList.map((fermentable) => (
          <ListItem key={fermentable.id}>
            <ListIcon as={MdCheckCircle} />
            {fermentable.name}
          </ListItem>
        ))}
      </List>
      <FermentableAddition isOpen={isOpen} onClose={onClose} onOpen={onOpen} />
    </>
  );
}
