import SidebarHeader from './Sidebar';
import { Button, useColorMode } from '@chakra-ui/react';

export default function SidebarNavigation({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <>
      <SidebarHeader>{children}</SidebarHeader>
    </>
  );
}
